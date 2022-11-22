package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class KakaoTalkNoticeSend extends AbstractEvent {

    private String noticeId;
    private String customerId;
    private String message;

    public KakaoTalkNoticeSend(NoticeInfo aggregate){
        super(aggregate);
    }
    public KakaoTalkNoticeSend(){
        super();
    }
}
