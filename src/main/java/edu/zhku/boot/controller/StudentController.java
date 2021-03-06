package edu.zhku.boot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import edu.zhku.boot.common.model.Result;
import edu.zhku.boot.entity.Student;
import edu.zhku.boot.service.StudentService;
import edu.zhku.boot.vo.StudentCascadeVo;
import edu.zhku.boot.vo.StudentInfoVo;
import edu.zhku.boot.vo.StudentQueryVo;
import edu.zhku.boot.vo.StudentScoreVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MJX
 * @date 2021/10/26
 */
@Api("学生管理Api")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation("通过id获取")
    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable Long id) {
        StudentInfoVo studentInfoVo = studentService.getStudentById(id);
        return Result.success(studentInfoVo);
    }

    @ApiOperation("新增")
    @PostMapping("/saveOrUpdate")
    public Result save(@RequestBody Student student) {
        studentService.saveOrUpdate(student);
        return Result.success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        studentService.removeById(id);
        return Result.success();
    }

    @ApiOperation("分页查询")
    @GetMapping("page/{current}/{size}")
    public Result queryPage(@PathVariable Long current, @PathVariable Long size, StudentQueryVo queryVo) {
        IPage<StudentInfoVo> page = studentService.getStudentInfoVoPage(current, size, queryVo);
        return Result.success(page);
    }

    @ApiOperation("获取课程的学生")
    @GetMapping("/getByCourse/{id}")
    public Result getByCourse(@PathVariable Long id) {
        List<StudentScoreVo> list = studentService.getByCourse(id);
        return Result.success(list);
    }

    @ApiOperation("获取级联数据")
    @GetMapping("/getCascade")
    public Result getCascade(){
        List<StudentCascadeVo> list = studentService.getCascade();
        return Result.success(list);
    }
}
