package kim.glushkova.checklist.service

import kim.glushkova.checklist.domain.Checklist
import org.springframework.stereotype.Service

/**
 *
 */
@Service
class ChecklistService {
    List<Checklist> findAllByName(String filter) {
        Collections.emptyList()
    }

    List<Checklist> findAll() {
        Collections.emptyList()
    }

    Checklist save(Checklist checklist) {
        checklist
    }
}
