package com.riding.todoback.bean.Small;

import com.riding.todoback.entity.BoardEntity;
import com.riding.todoback.repository.BoardRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SaveBoardDTOBean {

    GenerateUniqueIdBean generateUniqueIdBean;
    BoardRepositoryJPA boardRepositoryJPA;

    @Autowired
    public SaveBoardDTOBean(GenerateUniqueIdBean generateUniqueIdBean, BoardRepositoryJPA boardRepositoryJPA) {
        this.generateUniqueIdBean = generateUniqueIdBean;
        this.boardRepositoryJPA = boardRepositoryJPA;
    }

    public boolean exec(String title, String input) {

        // 아이디 생성
        long id = generateUniqueIdBean.exec();

        // 시간 생성
        LocalDateTime uTime = LocalDateTime.now();
        LocalDateTime mTime = LocalDateTime.now();

        // 메모장 데이터 저장
        BoardEntity boardEntity = new BoardEntity(id, "1", title, input, uTime, mTime);

        if (boardRepositoryJPA.save(boardEntity) == null)
            return false;
        return true;
    }
}
