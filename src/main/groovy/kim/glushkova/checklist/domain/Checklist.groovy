package kim.glushkova.checklist.domain

import java.time.LocalDateTime

/**
 *
 */
class Checklist {
    long id
    String name
    String description
    List<ChecklistItem> items
    LocalDateTime createdAt
}