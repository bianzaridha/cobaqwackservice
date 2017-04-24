package id.qwack.controller;


import id.qwack.model.DataChat;
import id.qwack.service.DataChatService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sabda
 */
@RestController
@RequestMapping(path = "/chat")
public class ChatController {
    
    @RequestMapping(path = "channel/{id}", method = RequestMethod.GET)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = DataChat.class)})
    public List<DataChat> getByChannel(@PathVariable("id") long channelId){
        DataChatService chat = new DataChatService();
        
        return chat.getAllByChannel(channelId);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String insertChat(@RequestBody DataChat c){
        DataChatService chat = new DataChatService();
        chat.save(c);
        
        return "inserted";
    }
}
