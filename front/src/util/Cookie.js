import {Cookie} from 'react-cookie'
import jwtDecode from 'jwt-decode'

export const setCookie = (name, value, ...options) => {
    return cookies.set(name, value, {...options})
  }
  
  export const getCookie = (name) => {
    return cookies.get(name)
  }
  
  export const removeCookie = (name, ...options) => {
    return cookies.remove(name, {...options})
  }

  