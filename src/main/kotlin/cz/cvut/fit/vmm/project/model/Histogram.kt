package cz.cvut.fit.vmm.project.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Histogram(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int? = null,
    val redValues: List<Int>? = null,
    val greenValues: List<Int>? = null,
    val blueValues: List<Int>? = null
)