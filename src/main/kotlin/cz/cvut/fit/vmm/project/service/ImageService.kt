package cz.cvut.fit.vmm.project.service

import com.google.firebase.cloud.StorageClient
import cz.cvut.fit.vmm.project.model.Image
import cz.cvut.fit.vmm.project.repository.ImageRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.concurrent.TimeUnit

private val log = KotlinLogging.logger {}

@Service
class ImageService(
    private val imageRepository: ImageRepository
) {
    fun uploadImage(file: MultipartFile): String {
        val bucket = StorageClient.getInstance().bucket()
        val name: String = file.originalFilename ?: "undefined"
        val blob = bucket.create(name, file.bytes, file.contentType)

        val url = blob.signUrl(24, TimeUnit.HOURS)

        return url.path
    }

    fun createImage(file: MultipartFile) {
        val link = uploadImage(file)

        val image = Image(
            filename = file.originalFilename,
            link = link
        )
        log.info { "Saved image, ${image.id}" }

        imageRepository.save(image)
    }
}