<template>
  <div class="form-container">
    <form @submit.prevent="saveStudent" class="student-form">
      <h2>{{ isEditing ? "Edit" : "Add" }} Student</h2>
      <div class="field">
        <label for="name">Name: </label>
        <input
          v-model="store.selectedStudent!.name"
          type="text"
          id="name"
          class="input-field"
          required
          placeholder="Enter student name"
        />
      </div>
      <div class="field">
        <label for="age">Age:</label>
        <input
          v-model="store.selectedStudent!.age"
          type="number"
          id="age"
          class="input-field"
          required
          placeholder="Enter student age"
        />
      </div>
      <button type="submit">{{ isEditing ? "Update" : "Add" }} Student</button>
    </form>
  </div>
</template>

<script setup lang="ts">
import { useRoute, useRouter } from "vue-router";
import { useStudentStore } from "../stores/studentStore";
import { onBeforeMount } from "vue";

const store = useStudentStore();
const router = useRouter();
const route = useRoute();

const isEditing = route.params.id !== "new";

onBeforeMount(async () => {
  await store.initialiseSelectedStudent(Number(route.params.id));
});

const saveStudent = async () => {
  if (isEditing && store.selectedStudent!.id !== null) {
    await store.updateStudent(store.selectedStudent!);
  } else {
    await store.addStudent(store.selectedStudent!);
  }
  router.push("/");
};
</script>

<style scoped>
.field {
  display: flex;
  /* justify-content: space-between; */
  margin-bottom: 20px;
}

.field label {
  width: 100px;
  font-weight: bold;
  margin-right: 10px;
}

.input-field {
  width: 100%;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
}
</style>
