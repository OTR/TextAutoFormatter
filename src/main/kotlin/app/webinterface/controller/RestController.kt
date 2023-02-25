package app.webinterface.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import app.webinterface.model.TextEntity
import app.webinterface.service.TextService
import java.io.Serializable

/**
 * GET / return greeting message
 * GET /text/all return all texts
 * GET /text/{id} return a text by the given ID
 * POST /text/new create a new text with fields supplied as JSON in request body
 * PUT /text/{id} update a text by the given ID with fields supplied as JSON
 *                in request body
 * DELETE /text/{id} delete a text by the given ID
 */
@RestController
class RestController {

    @Autowired
    private lateinit var textService: TextService

    companion object {
        private const val baseTextUrl = "/text"
    }

    @PostMapping(path = ["$baseTextUrl/new"])
    @ResponseStatus(HttpStatus.CREATED)
    fun createNewTextEntity(@RequestBody newTextEntity: TextEntity): TextEntity {
        return textService.create(newTextEntity)
    }

    @GetMapping(path = ["$baseTextUrl/all"])
    fun getAllTextEntities(): List<TextEntity> {
        return textService.getAll()
    }

    @GetMapping(path = ["$baseTextUrl/{id}"])
    fun getTextEntityById(@PathVariable("id") id: Int): ResponseEntity<Serializable> {
        val retrievedTextEntity = textService.getById(id)
        return if(retrievedTextEntity == null) {
            ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(jacksonObjectMapper().writeValueAsString(""))
        } else {
            ResponseEntity
                .ok()
                .body(retrievedTextEntity)
        }
    }

    @PutMapping(path = ["$baseTextUrl/{id}"])
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun updateTextEntityById(
        @PathVariable("id") id: Int,
        @RequestBody updatedTextEntity: TextEntity
    ): TextEntity {
        return textService.updateById(id, updatedTextEntity)
    }

    @DeleteMapping(path = ["$baseTextUrl/{id}"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTextEntityById(@PathVariable("id") id: Int): Unit {
        textService.deleteById(id)
        return Unit
    }
}