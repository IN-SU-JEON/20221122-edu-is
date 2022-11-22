package eduis.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="NoticeInfo_table")
@Data
public class NoticeInfo {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private String noticeId;
        private String customoerId;
        private String message;


}