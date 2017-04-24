/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.controller;


import id.qwack.model.ChannelTag;
import id.qwack.service.ChannelTagService;
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
@RequestMapping(path = "/channeltag")
public class ChannelTagController {
    
    @RequestMapping(method = RequestMethod.GET)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ChannelTag.class)})
    public List<ChannelTag> getAll(){
        ChannelTagService channelTag = new ChannelTagService();
        
        return channelTag.getAll();
    }
    
    @RequestMapping(path = "participant/{id}", method = RequestMethod.GET)
    public List<ChannelTag> getAllByParticipant(@PathVariable("id") long id){
        ChannelTagService channelTag = new ChannelTagService();
        
        return channelTag.getAllByChannel(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String insert(@RequestBody ChannelTag ct){
        ChannelTagService channelTag = new ChannelTagService();
        channelTag.save(ct);
        
        return "saved";
    }
}
