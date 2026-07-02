package com.gradeaide.api.config;

import com.gradeaide.api.entity.Destination;
import com.gradeaide.api.entity.Scholarship;
import com.gradeaide.api.entity.ServiceOffering;
import com.gradeaide.api.entity.Testimonial;
import com.gradeaide.api.repository.DestinationRepository;
import com.gradeaide.api.repository.ScholarshipRepository;
import com.gradeaide.api.repository.ServiceOfferingRepository;
import com.gradeaide.api.repository.TestimonialRepository;
import java.util.Objects;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final DestinationRepository destinationRepository;
    private final ScholarshipRepository scholarshipRepository;
    private final ServiceOfferingRepository serviceOfferingRepository;
    private final TestimonialRepository testimonialRepository;

    public DataSeeder(
            DestinationRepository destinationRepository,
            ScholarshipRepository scholarshipRepository,
            ServiceOfferingRepository serviceOfferingRepository,
            TestimonialRepository testimonialRepository) {
        this.destinationRepository = destinationRepository;
        this.scholarshipRepository = scholarshipRepository;
        this.serviceOfferingRepository = serviceOfferingRepository;
        this.testimonialRepository = testimonialRepository;
    }

    @Override
    public void run(String... args) {
        seedDestinations();
        seedScholarships();
        seedServices();
        seedTestimonials();
    }

    private void seedDestinations() {
        upsertDestination("Singapore", 30,
                "https://images.unsplash.com/photo-1525625293386-3f8f99389edd?auto=format&fit=crop&w=800&q=80", 1);
        upsertDestination("Thailand", 60,
                "https://images.unsplash.com/photo-1552465011-b4e21bf6e79a?auto=format&fit=crop&w=800&q=80", 2);
        upsertDestination("South Korea", 70,
                "https://images.unsplash.com/photo-1596422846543-75c6fc197f07?auto=format&fit=crop&w=800&q=80", 3);
        upsertDestination("Australia", 40,
                "https://images.unsplash.com/photo-1506973035872-a4ec16b8e8d9?auto=format&fit=crop&w=800&q=80", 4);
        upsertDestination("China", 120,
                "https://images.unsplash.com/photo-1508804185872-d7badad00f7d?auto=format&fit=crop&w=800&q=80", 5);
        upsertDestination("Canada", 90,
                "https://images.unsplash.com/photo-1503614472-8c93d56e92ce?auto=format&fit=crop&w=800&q=80", 6);
    }

    private void upsertDestination(String name, int institutionCount, String imageUrl, int displayOrder) {
        destinationRepository.findByName(name).ifPresentOrElse(
                destination -> {
                    destination.setInstitutionCount(institutionCount);
                    destination.setImageUrl(imageUrl);
                    destination.setDisplayOrder(displayOrder);
                    destinationRepository.save(destination);
                },
                () -> destinationRepository.save(Objects.requireNonNull(Destination.builder()
                        .name(name)
                        .institutionCount(institutionCount)
                        .imageUrl(imageUrl)
                        .displayOrder(displayOrder)
                        .build())));
    }

    private void seedScholarships() {
        if (scholarshipRepository.count() > 0) {
            return;
        }

        scholarshipRepository.saveAll(Objects.requireNonNull(java.util.List.of(
                Scholarship.builder()
                        .country("United Kingdom")
                        .title("Global Excellence Scholarship")
                        .fundingAmount("Up to £10,000")
                        .deadline("June 2026")
                        .applyUrl("#")
                        .displayOrder(1)
                        .build(),
                Scholarship.builder()
                        .country("Japan")
                        .title("MEXT Government Scholarship")
                        .fundingAmount("Full Tuition + Stipend")
                        .deadline("May 2026")
                        .applyUrl("#")
                        .displayOrder(2)
                        .build(),
                Scholarship.builder()
                        .country("Canada")
                        .title("International Entrance Award")
                        .fundingAmount("Up to $15,000 CAD")
                        .deadline("Ongoing")
                        .applyUrl("#")
                        .displayOrder(3)
                        .build())));
    }

    private void seedServices() {
        if (serviceOfferingRepository.count() > 0) {
            return;
        }

        serviceOfferingRepository.saveAll(Objects.requireNonNull(java.util.List.of(
                ServiceOffering.builder()
                        .badge("UP")
                        .title("University Placement")
                        .description("Expert guidance on selecting the right universities and courses based on your career goals.")
                        .displayOrder(1)
                        .build(),
                ServiceOffering.builder()
                        .badge("SG")
                        .title("Scholarship Guidance")
                        .description("Access to exclusive scholarship opportunities and assistance with application materials.")
                        .displayOrder(2)
                        .build(),
                ServiceOffering.builder()
                        .badge("VC")
                        .title("Visa Counseling")
                        .description("Support through the entire student visa process, ensuring all documentation is correct.")
                        .displayOrder(3)
                        .build(),
                ServiceOffering.builder()
                        .badge("PB")
                        .title("Pre-departure Briefing")
                        .description("Preparing you for life abroad, from accommodation to cultural adjustment.")
                        .displayOrder(4)
                        .build())));
    }

    private void seedTestimonials() {
        if (testimonialRepository.count() > 0) {
            return;
        }

        testimonialRepository.saveAll(Objects.requireNonNull(java.util.List.of(
                Testimonial.builder()
                        .studentName("Sai Yom Kham")
                        .university("Queen's University Belfast")
                        .quote("GradeAide guided me through the complex process of Russell Group applications and helped me secure a significant scholarship.")
                        .avatarUrl("https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?auto=format&fit=crop&w=200&q=80")
                        .displayOrder(1)
                        .build(),
                Testimonial.builder()
                        .studentName("Aye Myat Mon")
                        .university("University of Sheffield")
                        .quote("The career counseling sessions were eye-opening. They didn't just find me a university; they helped me find my path.")
                        .avatarUrl("https://images.unsplash.com/photo-1494790108377-be9c29b29330?auto=format&fit=crop&w=200&q=80")
                        .displayOrder(2)
                        .build())));
    }
}
