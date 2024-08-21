<template>
  <div>
    <h1>Student List</h1>
    <button @click="goToAddStudent">Add Student</button>
    <table v-if="store.students.length > 0">
      <thead>
        <tr>
          <th>Name</th>
          <th>Age</th>
          <th>Actions</th>
        </tr>
      </thead>

      <tbody>
        <StudentItem
          v-for="student in store.students"
          :key="student.id!"
          :student="student"
          @delete="deleteStudent"
          @edit="editStudent"
        />
      </tbody>
    </table>
    <p v-else>No students found</p>
  </div>
</template>

<script setup lang="ts">
import { useRouter } from "vue-router";
import StudentItem from "../components/StudentItem.vue";
import { useStudentStore } from "../stores/studentStore";
import { onMounted } from "vue";

const store = useStudentStore();
const router = useRouter();

onMounted(() => {
  store.fetchStudents();
});

function deleteStudent(id: number) {
  store.deleteStudent(id);
}

function editStudent(id: number) {
  router.push(`/student/${id}`);
}

function goToAddStudent() {
  router.push("/student/new");
}
</script>

<style scoped></style>
