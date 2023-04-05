import axios from "axios";

const BaseURL = "http://localhost:8080/api";
export const WorkerAPI = {
  getReservations: () => {
    const response = axios.get(`${BaseURL}/reservations`);
    return response.data;
  },
};
