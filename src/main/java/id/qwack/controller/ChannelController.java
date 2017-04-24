/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.controller;

import id.qwack.model.Channel;
import id.qwack.service.ChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.http.MediaType;
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
@RequestMapping(path="/channel")
@Api(value = "ChannelController" , produces = MediaType.APPLICATION_JSON_VALUE)
public class ChannelController {
    
    @RequestMapping(method = RequestMethod.GET)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Channel.class)})
    public List<Channel> getAll(){
        ChannelService channel = new ChannelService();
        
        return channel.getAll();
    }
    
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public Channel getById(@PathVariable("id") long id){
        ChannelService channel = new ChannelService();
        
        return channel.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String insert(@RequestBody Channel chnl){
        ChannelService channel = new ChannelService();
        channel.save(chnl);
        
        return "saved";
    }
}
