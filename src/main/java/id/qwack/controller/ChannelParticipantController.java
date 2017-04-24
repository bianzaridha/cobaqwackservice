/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.controller;


import id.qwack.model.ChannelParticipant;
import id.qwack.service.ChannelParticipantService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sabda
 */
@RestController
@RequestMapping(path = "/channelparticipant")
public class ChannelParticipantController {
    
    @RequestMapping(path = "channel/{id}", method = RequestMethod.GET)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ChannelParticipant.class)})
    public List<ChannelParticipant> getByChannel(@PathVariable("id") long channelId){
        ChannelParticipantService channelParticipant = new ChannelParticipantService();
        
        return channelParticipant.getAllByChannel(channelId); 
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String insertPerChannel(@RequestBody ChannelParticipant cp){
        ChannelParticipantService channelParticipant = new ChannelParticipantService();
        channelParticipant.save(cp);
        
        return "saved"; 
    }
}
