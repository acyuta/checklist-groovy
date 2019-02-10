package kim.glushkova.checklist.api

import kim.glushkova.checklist.domain.Checklist
import kim.glushkova.checklist.dto.ChecklistCreateBody
import kim.glushkova.checklist.dto.ChecklistDTO
import kim.glushkova.checklist.exceptions.ApiRequestException
import kim.glushkova.checklist.service.ChecklistService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 *
 */
@RequestMapping('/api/checklist')
@RestController
class ChecklistController {
    @Autowired
    ChecklistService checklistService

    @PostMapping
    ResponseEntity<?> create(@RequestBody ChecklistCreateBody dto) {
        Checklist checklist = new Checklist(name: dto.name, description: dto.description)
        checklist = checklistService.save(checklist)
        if (checklist)
            return new ResponseEntity(
                    [
                            id         : checklist.id,
                            name       : checklist.name,
                            createdAt  : checklist.createdAt,
                            description: checklist.description
                    ],
                    HttpStatus.CREATED
            )
        else
            throw new ApiRequestException(/Can't save checklist/)
    }

    @GetMapping
    List<ChecklistDTO> getAll(@RequestParam(name = "f", required = false) String filter) {
        if (filter)
            return checklistService.findAllByName(filter) as List<ChecklistDTO>
        else
            return checklistService.findAll() as List<ChecklistDTO>
    }
}
