package cz.cvut.fit.vmm.project.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne

@Entity
class Image(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: String? = null,
    val filename: String? = null,
    @OneToOne
    val histogram: Histogram? = null,
    val link: String? = null
)