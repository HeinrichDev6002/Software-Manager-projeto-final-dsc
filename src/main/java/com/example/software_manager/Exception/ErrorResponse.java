package com.example.software_manager.Exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record ErrorResponse(
@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
LocalDate localDate,
Integer code,
String status,
List<String> errors
) {}
