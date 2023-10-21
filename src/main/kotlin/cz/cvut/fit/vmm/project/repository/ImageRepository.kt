package cz.cvut.fit.vmm.project.repository

import cz.cvut.fit.vmm.project.model.Image
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ImageRepository : JpaRepository<Image, Long>