import axios, { AxiosInstance, AxiosRequestConfig } from "axios"

export const api: AxiosInstance = axios.create({
    baseURL: 'http://localhost:8088'
})