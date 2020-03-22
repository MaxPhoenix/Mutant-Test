package com.example.xmen.controller;

import com.example.xmen.model.dto.MutantCandidateDTO;
import com.example.xmen.services.MutantTestService;
import com.example.xmen.strategy.DnaCrossBoardDirectionMethodsContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantTestController {

    @Autowired
    private MutantTestService mutantTestService;

    @PostMapping("/mutant")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MutantCandidateDTO> testDna(@RequestBody MutantCandidateDTO mutantCandidateDTO){
        if(mutantCandidateDTO == null || mutantCandidateDTO.getDna().length == 0)
            return getMutantCandidateDTOResponseEntity(mutantCandidateDTO);

        boolean results = this.mutantTestService.isMutant(mutantCandidateDTO.getDna());
        if(!results)
            return getMutantCandidateDTOResponseEntity(mutantCandidateDTO);

        return ResponseEntity
                .ok(mutantCandidateDTO);
    }

    private ResponseEntity<MutantCandidateDTO> getMutantCandidateDTOResponseEntity(@RequestBody MutantCandidateDTO mutantCandidateDTO) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(mutantCandidateDTO);
    }

}
