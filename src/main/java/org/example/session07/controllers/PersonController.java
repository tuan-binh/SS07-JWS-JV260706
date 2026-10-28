package org.example.session07.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.session07.models.dto.req.PersonReq;
import org.example.session07.models.dto.wrapper.ApiResponse;
import org.example.session07.models.entities.Person;
import org.example.session07.models.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Person>>> findAll() {
        return ResponseEntity.ok(
//                ApiResponse.builder()
//                        .status(HttpStatus.OK.name())
//                        .message("Get All Person Successfully")
//                        .data(personService.findAll())
//                        .build()
                new ApiResponse<>(
                        HttpStatus.OK.name(),
                        "Get All Person Successfully",
                        personService.findAll()
                )
        );
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody PersonReq req, BindingResult result) {
        if (result.hasErrors()) {
            /*
                {
                    "field" : "message thông báo lỗi",
                    "field" : "message thông báo lỗi"
                }
            */
            Map<String, String> errors = new HashMap<>();

            List<FieldError> err = result.getFieldErrors();

            err.forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));

            return ResponseEntity.badRequest().body(
                    ApiResponse.builder()
                            .status(HttpStatus.BAD_REQUEST.name())
                            .message("Data Failed")
                            .data(errors)
                            .build()
            );

        }


        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.builder()
                        .status(HttpStatus.CREATED.name())
                        .message("Created Person Successfully")
                        .data(personService.create(req))
                        .build()
        );
    }

}
