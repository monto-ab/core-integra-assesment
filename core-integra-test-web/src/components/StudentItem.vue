<template>
  <tr>
    <td>{{ student.name }}</td>
    <td>{{ student.age }}</td>
    <td>
      <button @click="$emit('edit', student.id)">Edit</button>
      <button @click="$emit('delete', student.id)">Delete</button>
    </td>
  </tr>
</template>

<script setup lang="ts">
import { Student } from "../types/types";

defineProps<{
  student: Student;
}>();
</script>

<style scoped></style>
