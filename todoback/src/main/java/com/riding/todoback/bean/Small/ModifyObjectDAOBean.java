package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestBoardModify;
import com.riding.todoback.model.DTO.RequestTodoModify;
import com.riding.todoback.model.entity.BoardEntity;
import com.riding.todoback.model.entity.TodoEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ModifyObjectDAOBean {

    // 할 일 수정
    public TodoEntity exec(TodoEntity todoEntity, RequestTodoModify requestTodoModify){
        // 수정할 내용 받기
        String content = requestTodoModify.getContent();

        // 내용 수정
        todoEntity.setContent(content);
        todoEntity.setModifyTime(LocalDateTime.now());

        return todoEntity;
    }

    // 메모 수정
    public BoardEntity exec(BoardEntity boardEntity, RequestBoardModify requestBoardModify){
        // 수정할 내용 받기
        String title = requestBoardModify.getTitle();
        String content = requestBoardModify.getContent();

        // 내용 수정
        boardEntity.setTitle(title);
        boardEntity.setContent(content);
        boardEntity.setModifyTime(LocalDateTime.now());

        return boardEntity;
    }
}
