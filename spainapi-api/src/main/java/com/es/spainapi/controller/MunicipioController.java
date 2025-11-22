package com.es.spainapi.controller;


import com.es.spainapi.dto.MunicipioAllDTO;
import com.es.spainapi.dto.MunicipioDTO;
import com.es.spainapi.facade.MunicipioFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/municipios")
@Tag(
		name = "Municipios",
		description = "Operaciones para consultar municipios españoles"
)
public class MunicipioController {

	private final MunicipioFacade facade;

	public MunicipioController(MunicipioFacade facade) {
		this.facade = facade;
	}

	// --------------------------------------------------------------------------------------------
	// GET /byNmun/{nmun}
	// --------------------------------------------------------------------------------------------
	@Operation(
			summary = "Retrieve a municipality by nmun",
			description = "Get detailed information of a municipality using its NMUN (municipality identifier)."
	)
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "Municipality retrieved successfully",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = MunicipioDTO.class)
					)
			),
			@ApiResponse(
					responseCode = "400",
					description = "Invalid municipality identifier",
					content = @Content
			),
			@ApiResponse(
					responseCode = "404",
					description = "Municipality not found",
					content = @Content
			)
	})
	@GetMapping("/byNmun/{nmun}")
	public ResponseEntity<MunicipioDTO> getOneByNmun(
			@Parameter(
					description = "Municipality NMUN code",
					example = "001",
					required = true
			)
			@PathVariable String nmun
	) {
		return ResponseEntity.ok(facade.getOneByNmun(nmun));
	}

	// --------------------------------------------------------------------------------------------
	// GET /allByNprov/{nprov}
	// --------------------------------------------------------------------------------------------
	@Operation(
			summary = "Retrieve all municipalities by NPROV",
			description = "Get the list of municipalities belonging to a given province using its Province Name (NPROV)."
	)
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "Municipalities retrieved successfully",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = MunicipioAllDTO.class)
					)
			),
			@ApiResponse(
					responseCode = "400",
					description = "Invalid province name (NPROV)",
					content = @Content
			)
	})
	@GetMapping("/allByNprov/{nprov}")
	public ResponseEntity<MunicipioAllDTO> getallByNprov(
			@Parameter(
					description = "Province NPROV code",
					example = "ALMERIA",
					required = true
			)
			@PathVariable String nprov
	) {
		return ResponseEntity.ok(facade.getallByNprov(nprov));
	}

	// --------------------------------------------------------------------------------------------
	// GET /allByCprov/{cprov}
	// --------------------------------------------------------------------------------------------
	@Operation(
			summary = "Retrieve all municipalities by CPROV",
			description = "Get the list of municipalities belonging to a given province using its CPROV code."
	)
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "Municipalities retrieved successfully",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = MunicipioAllDTO.class)
					)
			),
			@ApiResponse(
					responseCode = "400",
					description = "Invalid province code (CPROV)",
					content = @Content
			)
	})
	@GetMapping("/allByCprov/{cprov}")
	public ResponseEntity<MunicipioAllDTO> getallByCprov(
			@Parameter(
					description = "Province CPROV code",
					example = "02",
					required = true
			)
			@PathVariable String cprov
	) {
		return ResponseEntity.ok(facade.getallByCprov(cprov));
	}
}
