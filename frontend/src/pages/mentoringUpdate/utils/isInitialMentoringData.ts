import type { mentoringCreateFormData } from '../../../common/types/mentoringCreateFormData';

export const isInitialMentoringData = (data: mentoringCreateFormData) => {
  return (
    data.price === 0 &&
    data.category.length === 0 &&
    data.introduction === '' &&
    data.career === 0 &&
    data.content === '' &&
    data.certificateInfos.length === 1 &&
    data.certificateInfos[0].id === '0' &&
    data.certificateInfos[0].title === null &&
    data.certificateInfos[0].type === null
  );
};
