package aermicioi.finlog.user.model;

import aermicioi.finlog.common.model.AuditableEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserEntity extends AuditableEntity {

    @NonNull
    private String email;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private String password;

    private String firstName;

    private String lastName;

}
