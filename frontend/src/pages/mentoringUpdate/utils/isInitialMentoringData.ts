import type { mentoringCreateFormData } from '../../../common/types/mentoringCreateFormData';

const initialMentoringData: mentoringCreateFormData = {
  price: 0,
  category: [],
  introduction: '',
  career: 0,
  content: '',
  certificateInfos: [
    {
      type: null,
      title: null,
    },
    {
      type: null,
      title: null,
    },
  ],
};

export const isInitialMentoringData = (data: mentoringCreateFormData) => {
  return (
    data.price === initialMentoringData.price &&
    data.introduction === initialMentoringData.introduction &&
    data.career === initialMentoringData.career &&
    data.content === initialMentoringData.content &&
    JSON.stringify(data.category) ===
      JSON.stringify(initialMentoringData.category) &&
    JSON.stringify(data.certificateInfos) ===
      JSON.stringify(initialMentoringData.certificateInfos)
  );
};
