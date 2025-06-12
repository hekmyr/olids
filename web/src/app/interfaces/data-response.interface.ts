import { BaseResponse } from "./base-response.interface"

export interface DataResponse<T> extends BaseResponse {
  data: T
}
