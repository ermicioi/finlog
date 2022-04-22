package aermicioi.finlog.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
abstract public class VersionedEntity extends AbstractEntity {

    @Version
    private Long version = 0L;

}
