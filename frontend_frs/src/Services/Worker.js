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

export async function addFlight(data) {
  const response = await axios.post(`${API_BASE_URL}/auth/AddFlight`, data);
  return response.data;
}
