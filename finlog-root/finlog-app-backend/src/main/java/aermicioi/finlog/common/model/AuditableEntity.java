package aermicioi.finlog.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
abstract public class AuditableEntity extends VersionedEntity {

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    @PrePersist
    protected void prePersist() {
        createdTime = LocalDateTime.now();
        updatedTime = LocalDateTime.now();
    }

    @PreUpdate
    protected void preUpdate() {
        updatedTime = LocalDateTime.now();
    }

}
