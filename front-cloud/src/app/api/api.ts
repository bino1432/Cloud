"use server"

import axios, { AxiosInstance } from "axios"

export const api: AxiosInstance = axios.create({
    baseURL: 'http://springboot-demo:8088'
})