package cz.cvut.fit.vmm.project.controller

import cz.cvut.fit.vmm.project.service.ImageService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/images")
class ImageController(
    private val imageService: ImageService
) {

    @PostMapping("/upload")
    fun uploadImage(@RequestParam("file") multipartFile: MultipartFile) {
        imageService.createImage(multipartFile)
    }
}