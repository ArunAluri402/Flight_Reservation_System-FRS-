import axios from "axios";
import { API_BASE_URL, ACCESS_TOKEN } from "../constants";

const request = (options) => {
  const headers = new Headers({
    "Content-Type": "application/json",
  });

  if (localStorage.getItem(ACCESS_TOKEN)) {
    headers.append(
      "Authorization",
      "Bearer " + localStorage.getItem(ACCESS_TOKEN)
    );
  }

  const defaults = { headers: headers };
  options = Object.assign({}, defaults, options);

  return fetch(options.url, { ...options }).then((response) =>
    response.json().then((json) => {
      if (!response.ok) {
        return Promise.reject(json);
      }
      return json;
    })
  );
};

export function login(loginRequest) {
  return request({
    url: API_BASE_URL + "/auth/signin",
    method: "POST",
    body: JSON.stringify(loginRequest),
  });
}

export function signup(signupRequest) {
  return request({
    url: `${API_BASE_URL}/auth/signup`,
    method: "POST",
    body: JSON.stringify(signupRequest),
  });
}

export function Adminsignup(signupRequest) {
  return request({
    url: `${API_BASE_URL}/auth/admin/signup`,
    method: "POST",
    body: JSON.stringify(signupRequest),
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

export const addFlight = () => async (data) => {
  const response = await axios.post(`${API_BASE_URL}/AddFlight`, data);
  return response.data;
};
