package cz.cvut.fit.vmm.project.service

import com.google.cloud.firestore.Firestore
import com.google.firebase.cloud.FirestoreClient
import com.google.firebase.cloud.StorageClient
import cz.cvut.fit.vmm.project.model.Image
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.concurrent.TimeUnit


@Service
class ImageService {
    fun uploadImage(file: MultipartFile): String {
        val bucket = StorageClient.getInstance().bucket()
        val name: String = file.originalFilename ?: "undefined"
        val blob = bucket.create(name, file.bytes, file.contentType)

        val url = blob.signUrl(24, TimeUnit.HOURS)

        return ""
    }

    fun createImage(file: MultipartFile): String {
        val firestore: Firestore = FirestoreClient.getFirestore();
        val image = Image(
            id = "1",
            link = "",
            filename = file.originalFilename!!,
            histogram = null
        )
        firestore.collection("image").document(image.id).set(image)
        return ""
    }
}