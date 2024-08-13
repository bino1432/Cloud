import { AxiosResponse } from "axios";
import { api } from "../api";

export const postFile = async(id: string, file: FormData) => {
    const response: AxiosResponse = await api.post(`/aws/file/${id}`, file)
    return response.data
}

export const getAllFiles = async(id: string) => {
    const response: AxiosResponse = await api.get(`/aws/file/${id}`)
    return response.data
}