package cz.cvut.fit.vmm.project.model

import jakarta.persistence.*

@Entity
class Image(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int? = null,
    val filename: String? = null,
    @OneToOne
    @JoinColumn(name="HISTOGRAM_ID")
    val histogram: Histogram? = null,
    val link: String? = null
)