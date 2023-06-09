import axios from "axios";
import { API_BASE_URL, ACCESS_TOKEN } from "../constants";

const request = (options) => {
  const headers = {
    "Content-Type": "application/json",
  };

  if (localStorage.getItem(ACCESS_TOKEN)) {
    headers["Authorization"] = "Bearer " + localStorage.getItem(ACCESS_TOKEN);
  }

  const defaults = { headers: headers };
  options = Object.assign({}, defaults, options);

  return axios(options)
    .then((response) => {
      if (!response.data) {
        return Promise.reject(response);
      }
      return response.data;
    })
    .catch((error) => {
      return Promise.reject(error.response.data);
    });
};

export function login(loginRequest) {
  return request({
    url: API_BASE_URL + "/auth/signin",
    method: "POST",
    data: loginRequest,
  });
}

export function signup(signupRequest) {
  return request({
    url: `${API_BASE_URL}/auth/signup`,
    method: "POST",
    data: signupRequest,
  });
}

export function Adminsignup(signupRequest) {
  return request({
    url: `${API_BASE_URL}/auth/signup`,
    method: "POST",
    data: signupRequest,
  });
}

export function checkUsernameAvailability(username) {
  return request({
    url: API_BASE_URL + "/user/checkUsernameAvailability?username=" + username,
    method: "GET",
  });
}

export function checkEmailAvailability(email) {
  return request({
    url: API_BASE_URL + "/user/checkEmailAvailability?email=" + email,
    method: "GET",
  });
}

export function getCurrentUser() {
  if (!localStorage.getItem(ACCESS_TOKEN)) {
    return Promise.reject("No access token set.");
  }

  return request({
    url: API_BASE_URL + "/user/me",
    method: "GET",
  });
}

export function getUserProfile(username) {
  return request({
    url: API_BASE_URL + "/users/" + username,
    method: "GET",
  });
}

export function getuserlist() {
  return request({
    url: API_BASE_URL + "/auth" + "/userdetails",
    method: "GET",
  });
}

// Flight Api

export function getFlightList() {
  return request({
    url: API_BASE_URL + "/auth" + "/getallFlights",
    method: "GET",
  });
}

export function getFlightByID(id) {
  return request({
    url: API_BASE_URL + "/auth" + "/flight" + "/" + id,
    method: "GET",
  });
}

// export const getFlightByID = async (id) => {
//   const response = await axios.get(`${API_BASE_URL}/auth/flight/${id}`);
//   return response.data;
// };

export const deleteFlight = async (id) => {
  const res = await axios.delete(`${API_BASE_URL}/auth/deleteflight/${id}`);
  return res.data;
};

// Route API

export const getallroutes = async () => {
  const res = await axios.get(`${API_BASE_URL}/auth/getallRoutes`);
  return res.data;
};

export const deleteFlightRoutes = async (id) => {
  const res = await axios.delete(
    `${API_BASE_URL}/auth/deleteflightroute/${id}`
  );
  return res.data;
};

export const addRoute = async (data) => {
  const res = await axios.post(`${API_BASE_URL}/auth/AddRoute`, data);
  return res.data;
};

// schedules

export const getallSchedules = async () => {
  const res = await axios.get(`${API_BASE_URL}/auth/getallSchedules`);
  return res.data;
};

export const deleteSchedule = async (id) => {
  const res = await axios.delete(`${API_BASE_URL}/auth/deleteSchedule/${id}`);
  return res.data;
};

export const addschedule = async (data) => {
  const res = await axios.post(`${API_BASE_URL}/auth/AddSchedule`, data);
  return res.data;
};
