package com.es.spainapi.controller;

import com.es.spainapi.dto.ProvinciaDTO;
import com.es.spainapi.facade.ProvinciaFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
		name = "Provincias",
		description = "Operaciones relacionadas con las provincias españolas"
)
@RestController
@RequestMapping("/provincias")
public class ProvinciaController {

	private final ProvinciaFacade facade;

	public ProvinciaController(ProvinciaFacade facade) {
		this.facade = facade;
	}

	@Operation(
			summary = "Retrieve all provinces",
			description = "Get a list of all spanish provinces stored in the database"
	)
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "List of provinces retrieved successfully",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = ProvinciaDTO.class)
					)
			)
	})
	@GetMapping("/all")
	public ResponseEntity<List<ProvinciaDTO>> getAll() {
		return ResponseEntity.ok(facade.getAll());
	}

	@Operation(
			summary = "Get a province by id",
			description = "Retrieve a single spanish province by its identifier"
	)
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "Province retrieved successfully",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = ProvinciaDTO.class)
					)
			),
			@ApiResponse(
					responseCode = "400",
					description = "Invalid id supplied",
					content = @Content
			),
			@ApiResponse(
					responseCode = "404",
					description = "Province not found",
					content = @Content
			)
	})
	@GetMapping("/{id}")
	public ResponseEntity<ProvinciaDTO> getOne(
			@Parameter(
					description = "Province identifier, from 02 - 52",
					example = "02"
			)
			@PathVariable String id
	) {
		return ResponseEntity.ok(facade.getOne(id));
	}

	@Operation(
			summary = "Create a new province",
			description = "Insert a new spanish province into the database"
	)
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "201",
					description = "Province created successfully",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = ProvinciaDTO.class)
					)
			),
			@ApiResponse(
					responseCode = "400",
					description = "Invalid request body",
					content = @Content
			)
	})
	@PostMapping("/")
	public ResponseEntity<ProvinciaDTO> insertOne(@RequestBody ProvinciaDTO dto) {
		return new ResponseEntity<>(facade.insertOne(dto), HttpStatus.CREATED);
	}

	@Operation(
			summary = "Delete a province",
			description = "Delete a spanish province by its identifier"
	)
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "204",
					description = "Province deleted successfully",
					content = @Content
			),
			@ApiResponse(
					responseCode = "400",
					description = "Invalid id supplied",
					content = @Content
			),
			@ApiResponse(
					responseCode = "404",
					description = "Province not found",
					content = @Content
			)
	})
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOne(
			@Parameter(
					description = "Province identifier",
					example = "AL"
			)
			@PathVariable String id
	) {
		facade.deleteOne(id);
	}
}
