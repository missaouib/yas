import { toastError } from '@commonServices/ToastService';
import PromotionGeneralInformation from 'modules/promotion/components/PromotionGeneralInformation';
import { PromotionDetail, PromotionDto } from 'modules/promotion/models/Promotion';
import { getPromotion, updatePromotion } from 'modules/promotion/services/PromotionService';
import { NextPage } from 'next';
import { useRouter } from 'next/router';
import { useEffect, useState } from 'react';
import { useForm } from 'react-hook-form';

const PromotionUpdate: NextPage = () => {
  const router = useRouter();
  const { id } = router.query;

  const {
    register,
    handleSubmit,
    formState: { errors },
    setValue,
    trigger,
  } = useForm<PromotionDto>();

  const [isSubmitting, setIsSubmitting] = useState(false);

  const [promotion, setPromotion] = useState<PromotionDetail>();

  useEffect(() => {
    if (id) {
      getPromotion(+id).then((data) => {
        setPromotion(data);
        setDefaultValues(data);
      });
    } else {
      toastError(`Promotion id ${id} not found`);
      router.push({ pathname: `/404` }); //NOSONAR
    }
  }, []);

  const setDefaultValues = (promotion: PromotionDetail) => {
    setValue('slug', promotion.slug);
    setValue('couponCode', promotion.couponCode);
    setValue('name', promotion.name);
    setValue('applyTo', promotion.applyTo);
    setValue('startDate', removeTime(promotion.startDate));
    setValue('endDate', removeTime(promotion.endDate));
    setValue('discountAmount', promotion.discountAmount);
    setValue('discountPercentage', promotion.discountPercentage);
    setValue('usageLimit', promotion.usageLimit);
    setValue('usageType', promotion.usageType);
    setValue('discountType', promotion.discountType);
    setValue('description', promotion.description);
    setValue('brandIds', promotion.brands?.map((brand) => brand.id) ?? []);
    setValue('categoryIds', promotion.categories?.map((category) => category.id) ?? []);
    setValue('productIds', promotion.products?.map((product) => product.id) ?? []);
    setValue('isActive', promotion.isActive);
  };

  const removeTime = (date: string) => {
    const DATE_PATTERN = /\d{4}-\d{2}-\d{2}/g;
    return date.match(DATE_PATTERN)![0];
  };

  const handleSubmitPromotion = async (event: PromotionDto) => {
    let promotion: PromotionDto = {
      id: +id!,
      slug: event.slug,
      couponCode: event.couponCode,
      name: event.name,
      applyTo: event.applyTo,
      startDate: event.startDate,
      endDate: event.endDate,
      discountAmount: event.discountAmount ?? 0,
      discountPercentage: event.discountPercentage ?? 0,
      usageLimit: event.usageLimit,
      usageType: event.usageType,
      discountType: event.discountType,
      description: event.description,
      brandIds: event.brandIds,
      categoryIds: event.categoryIds,
      productIds: event.productIds,
      isActive: event.isActive,
    };

    updatePromotion(promotion).then((response) => {
      if (response.status === 200) {
        router.replace('/promotion/manager-promotion');
      }
    });
  };

  const submitForm = () => {
    setIsSubmitting(true);
    handleSubmit(handleSubmitPromotion)();
  };

  const cancel = () => {
    window.location.href = '/promotion/manager-promotion';
  };

  return (
    <div className="row mt-5">
      <div className="col-md-8">
        <h2>Create Promotion</h2>
        <form>
          <PromotionGeneralInformation
            register={register}
            errors={errors}
            setValue={setValue}
            trigger={trigger}
            promotion={promotion}
            isSubmitting={isSubmitting}
          />
          <div className="mt-5">
            <button
              className="btn btn-primary"
              style={{ marginRight: '20px' }}
              type="button"
              onClick={submitForm}
            >
              Save
            </button>
            <button className="btn btn-danger ml-4" type="button" onClick={cancel}>
              Cancel
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default PromotionUpdate;
