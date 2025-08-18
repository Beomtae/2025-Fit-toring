import { API_ENDPOINTS } from '../constants/apiEndpoints';

import { apiClient } from './apiClient';

export const getLogout = async () => {
  return await apiClient.get({
    endpoint: API_ENDPOINTS.LOGOUT,
    withCredentials: true,
  });
};
