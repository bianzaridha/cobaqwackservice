/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.controller;


import id.qwack.model.Tag;
import id.qwack.service.TagService;
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
@RequestMapping(path = "/tag")
public class TagController {
    
    @RequestMapping(method = RequestMethod.GET)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Tag.class)})
    public List<Tag> getAll(){
        TagService tag = new TagService();
        
        return tag.getAll();
    }
    
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public Tag getById(@PathVariable("id") long id){
        TagService tag = new TagService();
        
        return tag.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String insert(@RequestBody Tag t){
        TagService tag = new TagService();
        tag.save(t);
        
        return "saved";
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id, @RequestBody Tag t){
        TagService tag = new TagService();
        tag.delete(t);
        
        return "Tag ID "+ id +" deleted";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody Tag t){
        TagService tag = new TagService();
        tag.update(t);
        
        return "Tag ID "+ t.getId() +" updated";
    }
}
