import { createRouter, createWebHistory } from "vue-router";
import StudentList from "../views/StudentList.vue";
import StudentForm from "../views/StudentForm.vue";

const routes = [
  { path: "/", component: StudentList },
  { path: "/student/:id?", component: StudentForm, props: true },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
