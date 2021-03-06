/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fptu.benchmarks.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

/**
 *
 * @author vansa
 */
@Data
public class Report {
    @JsonProperty("id")
    private String id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("permission")
    private String permission;
    @JsonProperty("pattern")
    private String pattern;
    @JsonProperty("path")
    private String path;
    @JsonProperty("type")
    private String type;
    @JsonProperty("command_list")
    private List<Command> commandList;
    private String operator;
    @JsonProperty("required")
    private boolean required;
    @JsonProperty("level")
    private String level;
    @JsonProperty("status")
    private boolean status;
    @JsonIgnore
    private String finalLevel;
}
