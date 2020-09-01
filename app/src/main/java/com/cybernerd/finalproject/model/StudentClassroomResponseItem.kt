package com.cybernerd.finalproject.model

data class StudentClassroomResponseItem(
    val course: CourseXXXXXXX,
    val description: String,
    val id: Int,
    val is_active: Boolean,
    val name: String,
    val semester: SemesterXXXXXX,
    val slug: String,
    val teacher: TeacherX
)