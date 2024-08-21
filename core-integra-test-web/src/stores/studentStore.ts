import { defineStore } from "pinia";
import axios from "axios";
import { Student } from "../types/types";
import { Ref, ref } from "vue";

export const useStudentStore = defineStore("student", () => {
  const url = "http://localhost:8080/api/students";

  const students: Ref<Student[]> = ref([]);

  const selectedStudent = ref<Student | null>(null);

  async function fetchStudents() {
    const response = await axios.get<Student[]>(url);
    students.value = response.data;
  }

  async function getStudent(id: number) {
    const response = await axios.get<Student>(`${url}/${id}`);
    selectedStudent.value = response.data;
    return response;
  }

  async function addStudent(student: Student) {
    const response = await axios.post(url, student);
    students.value.push(response.data);
  }

  async function updateStudent(student: Student) {
    await axios.put(`${url}/${student.id}`, student);
    const index = students.value.findIndex((s) => s.id === student.id);
    students.value[index] = student;
  }

  async function deleteStudent(id: number) {
    await axios.delete(`${url}/${id}`);
    students.value = students.value.filter((s) => s.id !== id);
  }

  async function initialiseSelectedStudent(id: number) {
    if (isNaN(id)) {
      selectedStudent.value = { id: null, name: "", age: 0 };
    } else {
      await getStudent(id);
    }
  }

  return {
    fetchStudents,
    getStudent,
    addStudent,
    updateStudent,
    deleteStudent,
    initialiseSelectedStudent,
    students,
    selectedStudent,
  };
});
