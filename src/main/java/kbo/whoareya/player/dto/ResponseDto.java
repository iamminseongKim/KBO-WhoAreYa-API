package kbo.whoareya.player.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class ResponseDto<T>{
    private int status;
    private String message;
    private T data;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
