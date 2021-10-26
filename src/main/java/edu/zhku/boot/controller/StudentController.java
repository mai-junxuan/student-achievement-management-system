package edu.zhku.boot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import edu.zhku.boot.common.model.Result;
import edu.zhku.boot.entity.Student;
import edu.zhku.boot.service.StudentService;
import edu.zhku.boot.vo.StudentInfoVo;
import edu.zhku.boot.vo.StudentQueryVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;

/**
 * @author MJX
 * @date 2021/10/26
 */
@Api("学生管理Api")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable Long id){
        StudentInfoVo studentInfoVo= studentService.getStudentById(id);
        return Result.success(studentInfoVo);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Student student){
        studentService.updateById(student);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        studentService.removeById(id);
        return Result.success();
    }

    @GetMapping("page/{current}/{size}")
    public Result queryPage(@PathVariable Long current, @PathVariable Long size, @RequestBody StudentQueryVo queryVo){
        IPage<StudentInfoVo> page=studentService.getStudentInfoVoPage(current,size,queryVo);
        return Result.success(page);
    }
}