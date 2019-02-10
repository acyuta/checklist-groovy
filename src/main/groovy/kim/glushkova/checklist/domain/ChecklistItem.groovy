package kim.glushkova.checklist.domain

import java.time.LocalDateTime

/**
 *
 */
class ChecklistItem {
    long id
    long parentId
    String name
    String description
    LocalDateTime checkedAt
}
